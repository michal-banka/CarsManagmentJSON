package models.enums;

public enum ColorEnum {
    WHITE,BLACK,RED,BLUE,GREEN,YELLOW,SILVER,GREY,OTHER;

    public ColorEnum getEnumByString(String str){
        for (ColorEnum color: ColorEnum.values()) {
            if (color.name().equals(str)){
                return color;
            }
        }
        return BLACK;
    }


}
