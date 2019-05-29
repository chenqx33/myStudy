CREATE OR REPLACE FUNCTION "public"."uuid"()
  RETURNS "pg_catalog"."text" AS $BODY$
declare
str1 text;
str2 text;
Mac text;

begin
-- MAC地址

Mac='aa:aa:aa:aa:aa:aa';
str1 := md5(MAC || now());
str2 := SUBSTRING(str1, 1,8)|| SUBSTRING(str1,9,4) || SUBSTRING(str1,13,4) || SUBSTRING(str1,17,4) || SUBSTRING(str1,21,12);
RETURN cast(str2 as varchar(36));
end;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
