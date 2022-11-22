public enum MonstersEnum {
    GOBLIN ("Гоблин",1),
    SKELET ("Скелет",2),
    DRACON ("Дракон",3),
    DEMON ("Демон",4);

    private final String type;
    private final int value;

    MonstersEnum(String type,int value){

        this.type = type;
        this.value = value;
    }
    public String getType(){
        return type;
    }

    public static MonstersEnum getMonstersEnum(int value){
        MonstersEnum[] monstersEnums = values();
        for (MonstersEnum monsters: monstersEnums){
            if (monsters.value == value){
                return monsters;
            }
        }
        throw new RuntimeException("Ошибка при создании персонажа!");
    }
}
