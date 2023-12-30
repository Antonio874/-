import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameSort {
    @DataProcessor
    public String nameSort(HashMap<String, Integer> data) {
        List<Map.Entry<String, Integer>> list = data.entrySet().stream().sorted((x, y) -> {
            return x.getKey().compareTo(y.getKey());
        }).toList();
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            output.append(entry.getKey());
            output.append(" - ");
            output.append(entry.getValue().toString());
            output.append(" мисок риса");
            output.append("\n");
        }
        return output.toString();
    }
}