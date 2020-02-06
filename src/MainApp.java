import java.util.*;

public class MainApp {

	public static void main(String[] args) {
		int choose = 0;
        int chYear;
        int chPrice;
        String chBrand;
        String chModel;
        Scanner in = new Scanner(System.in);

        Car[] cars = new Car[]{
        		new Car(1, "Toyota", "Avensis", 2016, "white", 12300, "01000000"),
                new Car(2, "ЗАЗ", "965", 1968, "black", 4500, "02000000"),
                new Car(3, "Chery", "QQ", 2008, "red", 3200, "03000000"),
                new Car(4, "Renault", "Logan", 2010, "yellow", 6000, "04000000"),
                new Car(5, "Deawoo", "Lanos", 2004, "silver", 4400, "05000000"),
                new Car(6, "Ford", "Mondeo", 2007, "green", 6800, "06000000"),
                new Car(7, "Volkswagen", "Caddy", 2007, "white", 7300, "07000000"),
                new Car(8, "Toyota", "Avensis", 2018, "white", 123000, "08000000"),
                new Car(9, "ЗАЗ", "965", 1968, "black", 45000, "09000000"),
                new Car(10, "Chery", "QQ", 2008, "red", 32000, "01000000"),
                new Car(11, "Renault", "Logan", 2010, "yellow", 60000, "01100000"),
                new Car(12, "Deawoo", "Lanos", 2004, "silver", 44000, "01200000"),
                new Car(13, "Ford", "Mondeo", 2007, "green", 68000, "01300000"),
                new Car(14, "Volkswagen", "Caddy", 2017, "white", 73000, "01400000"),
                new Car(15, "Toyota", "Avensis", 2016, "white", 1230, "01500000"),
                new Car(16, "ЗАЗ", "965", 1968, "black", 450, "01600000"),
                new Car(17, "Chery", "QQ", 2008, "red", 320, "01700000"),
                new Car(18, "Renault", "Logan", 2010, "yellow", 600, "01800000"),
                new Car(19, "Deawoo", "Lanos", 2004, "brows", 440, "01900000"),
                new Car(20, "Ford", "Mondeo", 1984, "green", 680, "02000000"),
                new Car(21, "Volkswagen", "Caddy", 2019, "white", 124000, "02100000")
        };
        
        List<Car> carsList = new ArrayList<>();
 
        do {
            showMenu();
            choose = in.nextInt();
            switch (choose) {
                case 1:
                    showCars(Arrays.asList(cars));
                    break;
                case 2:
                    System.out.println("Введіть марку авто, яку шукаєте:");
                    chBrand = in.next();
                    for (int i = 0; i < cars.length; i++) {
                        if (cars[i].getBrand().equalsIgnoreCase(chBrand))
                            carsList.add(cars[i]);
                    }
                    showResult(carsList);
                    break;
                case 3:
                    System.out.println("Введіть кількість років експлуатації авто:");
                    chYear = in.nextInt();
                    System.out.println("Введіть назву моделі авто:");
                    chModel = in.next();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date());
                    for (int i = 0; i < cars.length; i++) {
                        if (calendar.get(Calendar.YEAR) - chYear >= cars[i].getYear() && cars[i].getModel().equalsIgnoreCase(chModel)) {
                            carsList.add(cars[i]);
                        }
                    }
                    showResult(carsList);
                    break;
                case 4:
                    System.out.println("Введіть рік випуску авто:");
                    chYear = in.nextInt();
                    System.out.println("Введіть ціну:");
                    chPrice = in.nextInt();
                    for (int i = 0; i < cars.length; i++) {
                        if (cars[i].getYear() == chYear && cars[i].getPrice() > chPrice)
                            carsList.add(cars[i]);
                    }
                    showResult(carsList);
                    break;
                default:
                    break;
            }
        } while (choose != 0);
    }
 
    private static void showMenu() {
        System.out.printf("%20s \n", "Меню");
        System.out.println("1 - Всі авто");
        System.out.println("2 - Пошук за маркою");
        System.out.println("3 - Пошук за моделлю і часом експлуатації");
        System.out.println("4 - Пошук за роком випуску і ціною");
        System.out.println("0 - Вихід");
    }
 
    private static void showResult(List<Car> result) {
        if (result.isEmpty()) {
            System.out.println("За вказаними параметрами не знайдено жодного авто");
        } else {
            showCars(result);
            result.clear();
        }
    }
 
    private static void showCars(List<Car> carsList) {
        System.out.printf("%-12s%-10s%-15s%-10s%-10s%-20s\n", "Марка", "Модель", "Рік випуску", "Колір", "Ціна($)", "Реєстраційний номер");
        for (int i = 0; i < carsList.size(); i++) {
            System.out.printf("%-12s", String.valueOf(carsList.get(i).getBrand()));
            System.out.printf("%-10s", String.valueOf(carsList.get(i).getModel()));
            System.out.printf("%-15s", String.valueOf(carsList.get(i).getYear()));
            System.out.printf("%-10s", String.valueOf(carsList.get(i).getColor()));
            System.out.printf("%-10s", String.valueOf(carsList.get(i).getPrice()));
            System.out.printf("%-20s", String.valueOf(carsList.get(i).getRegNum()));
            System.out.println();
        }
    }
}
