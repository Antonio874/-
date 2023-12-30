import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValueSort {
    @DataProcessor
    public String valueSort(HashMap<String, Integer> data) {
        List<Map.Entry<String, Integer>> list = data.entrySet().stream().sorted((x, y) -> {
            return y.getValue().compareTo(x.getValue());
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