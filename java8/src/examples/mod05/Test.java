package examples.mod05;

public class Test {

    public static void main(String[] args) {
        PrepaidPhone pp = new PrepaidPhone(10);
        for (int i = 0; i < 10; i++) {
            System.out.println("Current limit: " + pp.getLimit());

            pp.makeCall(3);
            pp.addToLimit(10);

        }
        System.out.println("Current limit: " + pp.getLimit());
    }
}