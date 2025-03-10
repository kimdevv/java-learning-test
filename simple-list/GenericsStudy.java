public class GenericsStudy {

    public static void main(String[] args) {
        mission1();
        mission2();
        mission3();
        mission4();
        mission5();
    }

    private static void mission1() {
        SimpleListGeneric<Integer> values = new SimpleArrayListGeneric<>();
        values.add(1);
        values.add(2);

        Integer first = values.get(0);
        Integer second = values.get(1);

        System.out.println(first);
        System.out.println(second);
        System.out.println();
    }

    private static void mission2() {
        final String[] arrays = {"first", "second"};
        final SimpleListGeneric<String> values = SimpleListGeneric.<String>fromArrayToList(arrays);
        System.out.println(values.size());
        System.out.println();
    }

    private static void mission3() {
        final SimpleListGeneric<Double> doubleValues = new SimpleArrayListGeneric<>(0.5, 0.7);
        final SimpleListGeneric<Integer> intValues = new SimpleArrayListGeneric<>(1, 2);

        final double doubleTotal = SimpleListGeneric.sum(doubleValues); // 1.2
        final double intTotal = SimpleListGeneric.sum(intValues);  // 3
        System.out.println(doubleTotal);
        System.out.println(intTotal);
        System.out.println();
    }

    private static void mission4() {
        final SimpleListGeneric<Double> doubleValues = new SimpleArrayListGeneric<>(-0.1, 0.5, 0.7);
        final SimpleListGeneric<Integer> intValues = new SimpleArrayListGeneric<>(-10, 1, 2);

        final SimpleListGeneric<Double> filteredDoubleValues = SimpleListGeneric.filterNegative(doubleValues);
        final SimpleListGeneric<Integer> filteredIntValues = SimpleListGeneric.filterNegative(intValues);
        System.out.println(filteredDoubleValues.size());
        System.out.println(filteredIntValues.size());
        System.out.println();
    }

    private static void mission5() {
        final var laserPrinter = new LaserPrinter();

        final SimpleListGeneric<Printer> printers = new SimpleArrayListGeneric<>();
        final SimpleListGeneric<LaserPrinter> laserPrinters = new SimpleArrayListGeneric<>(laserPrinter);

        SimpleListGeneric.copy(laserPrinters, printers);

        System.out.println(printers.get(0) == laserPrinter); // true
        System.out.println();
    }
    static class Printer { }
    static class LaserPrinter extends Printer { }
}
