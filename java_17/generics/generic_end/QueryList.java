package java_17.generics.generic_end;

import java.util.ArrayList;
import java.util.List;


// an object must be both a Student and implement QueryItem
public class QueryList<T extends Student & QueryItem> extends ArrayList<T> {
    // private List<T> items;

    public QueryList() {

    }

    public QueryList(List<T> items) {
       super(items);;
    }

    public QueryList<T> getMatches(String field, String value) {
        QueryList<T> matches = new QueryList<>();
        for (var item : this) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    // public List<T> getMatches(String field, String value) {
    //     List<T> matches = new ArrayList<>();
    //     for (var item : items) {
    //         if (item.matchFieldValue(field, value)) {
    //             matches.add(item);
    //         }
    //     }
    //     return matches;
    // }

}
