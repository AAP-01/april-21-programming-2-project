void main() {

    // Is this useless? PoliceSystem has its own ArrayList and has a function unlike this one
    ArrayList<PoliceStaff> list = new ArrayList<>();

    Collections.sort(list);
    Collections.sort(list, new SortByLastName());
    Collections.sort(list, new SortByAge());
}
