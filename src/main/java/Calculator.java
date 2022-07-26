class Calculator {

    int friendsCount;

    String cart = "Добавленные товары:";
    double totalPrice = 0;

    Calculator(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    void addItem(Item item) {
        totalPrice += item.price;
        cart = cart + "\n" + item.name;

        System.out.println(item.name + " в корзине");
    }

    double divideSum() {
        return totalPrice / friendsCount;
    }
}
