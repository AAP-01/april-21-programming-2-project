void main() {

    ArrayList<PoliceStaff> list = new ArrayList<>();

    Collections.sort(list);
    Collections.sort(list, new SortByLastName());
    Collections.sort(list, new SortByAge());
}
