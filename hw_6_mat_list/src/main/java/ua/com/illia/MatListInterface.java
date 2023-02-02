package ua.com.illia;

public class MatListInterface {

    public void start() {
        System.out.println("----------------------------");
        System.out.println("------MATLIST'S METHODS DEMO--------");
        System.out.println("----------------------------");
        addElement();
        addElements();
        joinLists();
        intersectionList();
        sortDeskIncrease();
        sortDeskIncreaseBetweenFirstAndLast();
        sortDeskIncreaseAfterIndex();
        sortAscDecrease();
        sortAscDecreaseBetweenFirstAndLast();
        sortAscDecreaseAfterIndex();
        get();
        getMax();
        getMin();
        getAverage();
        getMedian();
        cut();
        clear();
        thanks();
    }

    public void addElement() {
        MatList<Number> matList = new MatList<>();
        System.out.println("------ADD ELEMENT------");
        System.out.println();
        System.out.println("Element 1 -----> 1.45");
        System.out.println("Element 2 -----> 5");
        System.out.println("Element 3 -----> 3.33");
        System.out.println("Element 4 -----> 345");
        System.out.println("Element 5 -----> 57456553");
        matList.add(1.45);
        matList.add(5);
        matList.add(3.33);
        matList.add(345);
        matList.add(57456553);
        System.out.println();
        System.out.println("-------ADD ELEMENT: ");
        System.out.println(matList);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void addElements() {
        MatList<Number> matList = new MatList<>();
        System.out.println("------ADD ELEMENTS------");
        System.out.println();
        System.out.println("Elements -----> [ 1, 6.56, 3.33, 345, 345, 45675, 5675466 ]");
        matList.add(1, 6.56, 3.33, 345, 345, 45675, 5675466);
        System.out.println();
        System.out.println("-------ADD ELEMENTS: ");
        System.out.println(matList);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void joinLists() {
        MatList<Number> matList1 = new MatList<>();
        MatList<Number> matList2 = new MatList<>();
        System.out.println("------JOIN LISTS------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 1.45, 5, 3.33, 345, 57456553 ]");
        matList1.add(1.45, 5, 3.33, 345, 57456553);
        System.out.println();
        System.out.println("Elements matList2-----> [ 1, 6.56, 3.33, 345, 345, 45675, 5675466 ]");
        matList2.add(1, 6.56, 3.33, 345, 345, 45675, 5675466);
        matList1.join(matList2);
        System.out.println();
        System.out.println("-------JOIN: ");
        System.out.println(matList1);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void intersectionList() {
        MatList<Number> matList1 = new MatList<>();
        MatList<Number> matList2 = new MatList<>();
        System.out.println("------INTERSECTION LIST------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 1.45, 5, 3.33, 345, 57456553 ]");
        matList1.add(1.45, 5, 3.33, 345, 57456553);
        System.out.println();
        System.out.println("Elements matList2-----> [ 1, 6.56, 3.33, 345, 345, 45675, 5675466 ]");
        matList2.add(1, 6.56, 3.33, 345, 345, 45675, 5675466);
        matList1.intersection(matList2);
        System.out.println();
        System.out.println("-------INTERSECTION: ");
        System.out.println(matList1);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void sortDeskIncrease() {
        MatList<Integer> matList = new MatList<>();
        MatList<Number> sortedMatList = new MatList<>();
        System.out.println("------SORT INCREASE LIST------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888);
        System.out.println();
        matList.sortDesc();
        for (Integer sorted : matList) {
            sortedMatList.add(sorted);
        }
        System.out.println("-------SORT INCREASE: ");
        System.out.println(sortedMatList);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void sortDeskIncreaseBetweenFirstAndLast() {
        MatList<Integer> matList = new MatList<>();
        MatList<Number> sortedMatList = new MatList<>();
        System.out.println("------SORT INCREASE LIST BETWEEN FIRST AND LAST------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888, 5, 7, 7, 3, 345, 777, 34535, 45, 567, 888 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888, 5, 7, 7, 3, 345, 777, 34535, 45, 567, 888);
        System.out.println();
        matList.sortDesc(2, 10);
        for (Integer sorted : matList) {
            sortedMatList.add(sorted);
        }
        System.out.println("-------SORT INCREASE BETWEEN FIRST AND LAST: ");
        System.out.println("From 2 to 10");
        System.out.println(sortedMatList);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void sortDeskIncreaseAfterIndex() {
        MatList<Integer> matList = new MatList<>();
        MatList<Number> sortedMatList = new MatList<>();
        System.out.println("------SORT INCREASE LIST AFTER INDEX------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888, 5, 7, 7, 3, 345, 777, 34535, 45, 567, 888 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888, 5, 7, 7, 3, 345, 777, 34535, 45, 567, 888);
        System.out.println();
        matList.sortDesc(7);
        for (Integer sorted : matList) {
            sortedMatList.add(sorted);
        }
        System.out.println("-------SORT INCREASE AFTER INDEX: ");
        System.out.println("From 7");
        System.out.println(sortedMatList);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void sortAscDecrease() {
        MatList<Integer> matList = new MatList<>();
        MatList<Number> sortedMatList = new MatList<>();
        System.out.println("------SORT DECREASE LIST------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888);
        System.out.println();
        matList.sortAsc();
        for (Integer sorted : matList) {
            sortedMatList.add(sorted);
        }
        System.out.println("-------SORT DECREASE: ");
        System.out.println(sortedMatList);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void sortAscDecreaseBetweenFirstAndLast() {
        MatList<Integer> matList = new MatList<>();
        MatList<Number> sortedMatList = new MatList<>();
        System.out.println("------SORT DECREASE LIST BETWEEN FIRST AND LAST------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888, 5, 7, 7, 3, 345, 777, 34535, 45, 567, 888 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888, 5, 7, 7, 3, 345, 777, 34535, 45, 567, 888);
        System.out.println();
        matList.sortAsc(3, 12);
        for (Integer sorted : matList) {
            sortedMatList.add(sorted);
        }
        System.out.println("-------SORT DECREASE BETWEEN FIRST AND LAST: ");
        System.out.println("From 3 to 12");
        System.out.println(sortedMatList);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void sortAscDecreaseAfterIndex() {
        MatList<Integer> matList = new MatList<>();
        MatList<Number> sortedMatList = new MatList<>();
        System.out.println("------SORT DECREASE LIST AFTER INDEX------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888, 5, 7, 7, 3, 345, 777, 34535, 45, 567, 888 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888, 5, 7, 7, 3, 345, 777, 34535, 45, 567, 888);
        System.out.println();
        matList.sortAsc(5);
        for (Integer sorted : matList) {
            sortedMatList.add(sorted);
        }
        System.out.println("-------SORT DECREASE AFTER INDEX: ");
        System.out.println("From 5");
        System.out.println(sortedMatList);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void get() {
        MatList<Integer> matList = new MatList<>();
        System.out.println("------GET BY INDEX------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888);
        System.out.println();
        System.out.println("-------GET BY INDEX: ");
        System.out.println("Index 3");
        System.out.println("Result { " + matList.get(3) + " }");
        System.out.println(".....................................................");
        System.out.println();
    }

    public void getMax() {
        MatList<Integer> matList = new MatList<>();
        System.out.println("------GET MAX------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888);
        System.out.println();
        System.out.println("-------GET MAX: ");
        System.out.println();
        System.out.println("Result { " + matList.getMax() + " }");
        System.out.println(".....................................................");
        System.out.println();
    }

    public void getMin() {
        MatList<Integer> matList = new MatList<>();
        System.out.println("------GET MIN------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888);
        System.out.println();
        System.out.println("-------GET MIN: ");
        System.out.println();
        System.out.println("Result { " + matList.getMin() + " }");
        System.out.println(".....................................................");
        System.out.println();
    }

    public void getAverage() {
        MatList<Integer> matList = new MatList<>();
        System.out.println("------GET AVERAGE------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888);
        System.out.println();
        System.out.println("-------GET AVERAGE: ");
        System.out.println();
        System.out.println("Result { " + matList.getAverage() + " }");
        System.out.println(".....................................................");
        System.out.println();
    }

    public void getMedian() {
        MatList<Integer> matList = new MatList<>();
        System.out.println("------GET MEDIAN------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888);
        System.out.println();
        System.out.println("-------GET MEDIAN: ");
        System.out.println();
        System.out.println("Result { " + matList.getMedian() + " }");
        System.out.println(".....................................................");
        System.out.println();
    }

    public void cut() {
        MatList<Integer> matList = new MatList<>();
        System.out.println("------CUT------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888, 78976, 87908765 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888, 78976, 87908765);
        System.out.println();
        System.out.println("-------CUT: ");
        System.out.println("From 1 to 5");
        System.out.println(matList.cut(1, 5));
        System.out.println(".....................................................");
        System.out.println();
    }

    public void clear() {
        MatList<Integer> matList = new MatList<>();
        System.out.println("------CLEAR------");
        System.out.println();
        System.out.println("Elements matList1 -----> [ 33333, 55555, 777, 1111111, 8888888 ]");
        matList.add(33333, 55555, 777, 1111111, 8888888);
        System.out.println();
        System.out.println("-------CLEAR: ");
        System.out.println();
        matList.clear();
        System.out.println(matList);
        System.out.println(".....................................................");
        System.out.println();
    }

    public void thanks() {
        System.out.println();
        System.out.println("===THANK YOU)))===THANK YOU)))===THANK YOU)))===THANK YOU)))===THANK YOU)))===THANK YOU)))===");
    }
}
