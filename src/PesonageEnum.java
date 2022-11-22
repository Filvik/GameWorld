public enum PesonageEnum {

    IVAN("Иван", 1),
    ANDRY("Андрей", 2),
    SERGEY("Сергей", 3),
    EGOR("Егор", 4);

    private final String type;
    private final int value;

    PesonageEnum(String type, int value) {

        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public static PesonageEnum getPesonageEnum(int value) {
        System.out.println(value);
        PesonageEnum[] pesonageEnums = values();
        for (PesonageEnum pesonage : pesonageEnums) {
            if (pesonage.value == value) {
                return pesonage;
            }
        }
        throw new RuntimeException("Ошибка при создании персонажа!");
    }
}
