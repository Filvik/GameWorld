public class DrugDealer {
    final static int potion = 50;
    int price;
    int quantityInStock;
    long time = System.currentTimeMillis();

    public DrugDealer(){
        price = 2;
        quantityInStock = 10;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void purchase(Personage personage) {

        if (quantityInStock >= 1) {
            if ((personage.getGold() - price) >= 0) {

                personage.setGold(personage.getGold() - price);
                personage.setHealth(personage.getHealth() + potion);
                quantityInStock --;
                price = price + 5;    //Удорожание каждой последующей порции.
                System.out.println("Персонаж " + personage.getName() + " вылечился приобретенным зельем");
                System.out.println("Текущий уровень здоровья " + personage.getHealth() + " Осталось " + personage.getGold() + " золота");
            } else {
                System.out.println("Не хватает золота для преобретения зелья!");
            }
            time = System.currentTimeMillis();
        }
        else {
            System.out.println("У торговца закончилось зелье, но оно скоро вновь появится в наличие!");
            if (System.currentTimeMillis() - time >= 60_000){
                price = 100;
                quantityInStock = 10;
            }
        }
    }
}
