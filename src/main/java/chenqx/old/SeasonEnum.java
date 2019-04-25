package chenqx.old;

public enum SeasonEnum {
    SPRING("春"),
    SUMMER("夏"),
    AUTUMN("秋"),
    WINTER("冬");

    private String season;

    SeasonEnum(String season) {
        this.season = season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSeason() {
        return season;
    }
    public String getThis(){
        return ""+this;
    }
}

class tests{
    public static void main(String[] args) {

    }


}
