import java.util.Comparator;

public class SortByAge implements Comparator<PoliceStaff> {
    @Override
    public int compare(PoliceStaff a, PoliceStaff b){
        return Integer.compare(a.getAge(), b.getAge());
    }
}
