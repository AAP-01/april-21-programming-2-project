import java.util.Comparator;

public class SortByLastName implements Comparator<PoliceStaff> {

    @Override
    public int compare(PoliceStaff a, PoliceStaff b){
        return a.getLastName().compareTo(b.getLastName());
    }
}
