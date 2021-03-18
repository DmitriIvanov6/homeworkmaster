package Lesson5;

public class Lesson5 {
    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Иванов И.И.", "фронтэнд", "iivanov@nomail.ru", "+79991234567",
                30000, 25);
        persArray[1] = new Employee("Петров П.П.", "бэкэнд", "ppetrov@nomail.ru", "+71231233232",
                30000, 41);
        persArray[2] = new Employee("Сидоров С.С.", "фулстек", "sidorovss@nomail.ru", "+73113123414",
                60000, 33);
        persArray[3] = new Employee("Кузнецов В.В.", "тестировщик", "vvsidorov@nomail.ru", "+75435436464",
                15000, 18);
        persArray[4] = new Employee("Смирнов А.А.", "проджект менеджер", "bigboss@nomail.ru", "+76661726541",
                80000, 52);
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                persArray[i].printInfo();
            }
        }
    }
}

