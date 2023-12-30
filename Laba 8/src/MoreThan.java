import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoreThan {
    private int count;
    public MoreThan(int count){
        this.count= count;
    }
    @DataProcessor
    public String moreThanTen(HashMap<String, Integer> data) {
        List<Map.Entry<String, Integer>> list = data.entrySet().stream().filter((x) -> x.getValue() > count).toList();
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