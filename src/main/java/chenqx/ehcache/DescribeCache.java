package chenqx.ehcache;

/**
 * @author chenqx 2020-03-30
 * @instruction  用ehcache做 heap -> off-heap -> disk 三级缓存
 */
public class DescribeCache {
//    private static final String DESCRIBE_CHANGE_EVENT = "describe-change-event";
//    public static final String DESCRIBE_CLEAR_EVENT = "describe-clear-event";
//    private CacheManager cacheManager;
//    private Cache<String, String> vipCache;
//    private Cache<String, String> cache;
//    /**
//     * 基于 (apiName, lang, traceId) 获取describe信息，保存非vip企业的描述信息
//     */
//    private LoadingCache<String, String> describeJVMCache;
//
//    /**
//     * (tenantId, apiName, lang) 获取describe信息，避免vip企业频繁加载描述信息并进行反序列化
//     */
//    private LoadingCache<String, String> vipJVMCache;
//
//    @Autowired
//    private HttpService httpService;
//    @PostConstruct
//    void init() {
//            int expireInSeconds = 300;
//            int describeCacheSize = 5000;
//            LoadingCache<String, String> jvmCache, old;
//
//            // 单个session内5分钟有效
//            jvmCache = Caffeine.newBuilder().maximumSize(describeCacheSize).expireAfterAccess(expireInSeconds, TimeUnit.SECONDS).build(getCacheLoader());
//            old = describeJVMCache;
//            this.describeJVMCache = jvmCache;
//            if (old != null) {
//                old.invalidateAll();
//                old.cleanUp();
//            }
//
//            // vip企业一小时有效
//            expireInSeconds = 3600;
//            describeCacheSize = 5000;
//            jvmCache = Caffeine.newBuilder().maximumSize(describeCacheSize).expireAfterAccess(expireInSeconds, TimeUnit.SECONDS).build(getCacheLoader());
//            old = vipJVMCache;
//            this.vipJVMCache = jvmCache;
//            if (old != null) {
//                old.invalidateAll();
//                old.cleanUp();
//            }
//
//            int heapEntries = 1000;
//            int offHeapSize = 200;
//            ResourcePools pools = ResourcePoolsBuilder.heap(heapEntries).offheap(offHeapSize, MemoryUnit.MB).disk(2, MemoryUnit.GB).build();
//            if (cacheManager == null) {
//                String cacheRootDir = Resources.getResource(DescribeCache.class, "/").getFile() + "/../../../../metadata_cache";
//                cacheManager = CacheManagerBuilder.newCacheManagerBuilder().with(CacheManagerBuilder.persistence(cacheRootDir)).build(true);
//                CacheConfiguration<String, String> configuration = CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class,
//                        String.class,
//                        pools).withExpiry(ExpiryPolicy.NO_EXPIRY).withValueSerializer(new PbSerializer()).build();
//                vipCache = cacheManager.createCache("vip-describe-cache", configuration);
//                cache = cacheManager.createCache("describe-cache", configuration);
//            } else {
//                cacheManager.close();
//                vipCache.getRuntimeConfiguration().updateResourcePools(pools);
//                cache.getRuntimeConfiguration().updateResourcePools(pools);
//            }
//
//    }
//
//
//
//    void invalidateDescribeCache(String describeApiName) {
//        Set<String> keySet = vipJVMCache.asMap().keySet();
//        for (String key : keySet) {
//            if (key.contains(describeApiName)) {
//                vipJVMCache.invalidate(key);
//            }
//        }
//        Set<String> keySet2 = describeJVMCache.asMap().keySet();
//        for (String key : keySet2) {
//            if (key.contains(describeApiName)) {
//                describeJVMCache.invalidate(key);
//            }
//        }
//    }
//
//
//    public void purgeLocalCache(String tenantId, String describeApiName) {
//        if (gray.isAllow("allow_ehcache", tenantId)) {
//            if (gray.isAllow("describe-vip-cache", tenantId)) {
//                vipCache.remove(cacheKey(tenantId, describeApiName, ""));
//                vipCache.remove(cacheKey(tenantId, describeApiName, "zh_CN"));
//                vipCache.remove(cacheKey(tenantId, describeApiName, "zh_TW"));
//                vipCache.remove(cacheKey(tenantId, describeApiName, "en"));
//            } else {
//                cache.remove(cacheKey(tenantId, describeApiName, ""));
//                cache.remove(cacheKey(tenantId, describeApiName, "zh_CN"));
//                cache.remove(cacheKey(tenantId, describeApiName, "zh_TW"));
//                cache.remove(cacheKey(tenantId, describeApiName, "en"));
//            }
//        } else {
//            if (gray.isAllow("describe-vip-cache", tenantId)) {
//                vipJVMCache.invalidate(cacheKey(tenantId, describeApiName, ""));
//                vipJVMCache.invalidate(cacheKey(tenantId, describeApiName, "zh_CN"));
//                vipJVMCache.invalidate(cacheKey(tenantId, describeApiName, "zh_TW"));
//                vipJVMCache.invalidate(cacheKey(tenantId, describeApiName, "en"));
//            } else {
//                describeJVMCache.invalidate(cacheKey(tenantId, describeApiName, ""));
//                describeJVMCache.invalidate(cacheKey(tenantId, describeApiName, "zh_CN"));
//                describeJVMCache.invalidate(cacheKey(tenantId, describeApiName, "zh_TW"));
//                describeJVMCache.invalidate(cacheKey(tenantId, describeApiName, "en"));
//            }
//        }
//    }
//
//    public IObjectDescribe findByTenantIdAndDescribeApiName(String tenantId, String objectDescribeApiName) throws MetadataServiceException {
//        return findByTenantIdAndDescribeApiName(tenantId, objectDescribeApiName, new ActionContext());
//    }
//
//
//
//
//    private String cacheKey(String tenantId, String describeApiName, String lang) {
//        lang = MoreObjects.firstNonNull(lang, "");
//        lang = CharMatcher.is('-').replaceFrom(lang, '_');
//        return Joiner.on('\u0003').join(tenantId, describeApiName, lang);
//    }
//
//    private CacheLoader<String, IObjectDescribe> getCacheLoader() {
//        return key -> {
//            Iterator<String> it = Splitter.on('\u0003').split(key).iterator();
//            String tenantId = it.next();
//            String describeApiName = it.next();
//            String lang = it.next();
//            ActionContext context = new ActionContext();
//            context.setEnterpriseId(tenantId);
//            if (lang.length() > 0) {
//                context.setLang(lang);
//            }
//            return loadDescribe(tenantId, describeApiName, context.getLang());
//        };
//    }
//
//    private IObjectDescribe getObjectDescribeFromEhCache(String tenantId, String describeApiName, String lang) {
//        // 先从session-cache获取，保证在同一个request-session期间只获取一次
//        String cacheKey = cacheKey(tenantId, describeApiName, lang);
//        IObjectDescribe describeInCache;
//        boolean isVip = gray.isAllow("describe-vip-cache", tenantId);
//        try {
//            if (isVip) {
//                describeInCache = vipCache.get(cacheKey);
//            } else {
//                describeInCache = cache.get(cacheKey);
//            }
//            if (describeInCache == null) {
//                describeInCache = loadDescribe(tenantId, describeApiName, lang);
//                if (describeInCache != null) {
//                    if (isVip) {
//                        vipCache.put(cacheKey, (ObjectDescribe) describeInCache);
//                    } else {
//                        cache.put(cacheKey, (ObjectDescribe) describeInCache);
//                    }
//                }
//            }
//            // 有些业务场景会修改describe信息，如果原位修改会导致问题，所以复制一份传出去
//            return describeInCache == null ? null : describeInCache.copy();
//        } catch (Exception e) {
//            log.error("getObjectDescribe error,tenant_id:{},describeApiName:{}", tenantId, describeApiName, e);
//            throw e;
//        }
//    }
//
//    private IObjectDescribe loadDescribe(String tenantId, String describeApiName, String lang) {
//        ActionContext context = new ActionContext();
//        context.setEnterpriseId(tenantId);
//        //describe静态化
//        String url;
//        if (null != lang && lang.length() > 0) {
//            url = staticDescribeUrl +
//                    String.format("/paas/metadata/describe/findBy/apiName.json?tenantId=%s&describeApiName=%s&lang=%s", tenantId, describeApiName, lang.replace("-", "_"));
//            context.setLang(lang);
//        } else {
//            url = staticDescribeUrl + String.format("/paas/metadata/describe/findBy/apiName.json?tenantId=%s&describeApiName=%s", tenantId, describeApiName);
//        }
//
//        String describeJson = httpService.getJsonString(url);
//        if (null != describeJson) {
//            if ("{}".equals(describeJson) || Strings.isNullOrEmpty(describeJson)) {
//                return null;
//            }
//            IObjectDescribe objectDescribe = new ObjectDescribe();
//            objectDescribe.fromJsonString(describeJson);
//            if (null == objectDescribe.get("is_udef", Boolean.class) && PresetObjectApiName.isDescribePresetObject(objectDescribe.getApiName())) {
//                Describe describe = systemDescribeCollection.getDescribe(tenantId, describeApiName);
//                if (null != describe) {
//                    describe.setTenantId(tenantId);
//                }
//                try {
//                    return describeHandler.convertDescribeToIObjectDescribeForReturn(describe, context);
//                } catch (MetadataServiceException e) {
//                    return null;
//                }
//            } else {
//                return objectDescribe;
//            }
//        } else {
//            try {
//                Describe describe = loadFromDatabase(tenantId, describeApiName);
//                //预置对象特殊处理，负数的tenantId说明是系统库
//                return getObjectDescribe(tenantId, describeApiName, context, describe);
//            } catch (MetadataServiceException e) {
//                log.warn("cannot load describe from database, ei:{}, apiName:{}, ", tenantId, describeApiName, e);
//                return null;
//            }
//        }
//    }
//
//    private Describe loadFromDatabase(String tenantId, String apiName) throws MetadataServiceException {
//        try {
//            return describeMapper.setTenantId(tenantId).findByTenantIdAndObjectDescribeApiName(tenantId, apiName, upgradeGrayer.getGrayedReleaseVersion(tenantId));
//        } catch (Exception e) {
//            log.error("tenantId:{}, apiName:{}. Exception in query objectDescribe", tenantId, apiName, e);
//            throw new MetadataServiceException(FS_PAAS_MDS_DESC_QUERY_MONGODB_EXCEPTION, "Exception in query objectDescribe", e);
//        }
//    }
//
//    @PreDestroy
//    void destroy() {
//        cacheManager.close();
//    }
}
