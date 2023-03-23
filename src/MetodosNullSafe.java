import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class MetodosNullSafe {

    public static void main(String[] args) {

        // 1) Objects.equals
        System.out.println("1) Objects.equals");
        String s1 = null;
        String s2 = "Teste";
        System.out.println(Objects.equals(s1, s2)); // Output: false
        System.out.println(Objects.equals(s2, "Teste")); // Output: true

        // 2) Optional.orElse
        System.out.println("\n2) Optional.orElse");
        Optional<String> opt1 = Optional.ofNullable(null);
        Optional<String> opt2 = Optional.of("Teste");
        System.out.println(opt1.orElse("default")); // Output: "default"
        System.out.println(opt2.orElse("default")); // Output: "Teste"

        // 3) StringUtils.isNotBlank
        System.out.println("\n3) StringUtils.isNotBlank");
        String str1 = null;
        String str2 = "  ";
        String s3 = "Teste";
        System.out.println(StringUtils.isNotBlank(str1)); // Output: false
        System.out.println(StringUtils.isNotBlank(str2)); // Output: false
        System.out.println(StringUtils.isNotBlank(s3)); // Output: true

        // 4) Collections.isEmpty()
        System.out.println("\n4) Collections.isEmpty()");
        List<String> list1 = null;
        List<String> list2 = new ArrayList<>();
        List<String> list3 = Arrays.asList("Teste", "Outro Teste");
        System.out.println(CollectionUtils.isEmpty(list1)); // Output: true
        System.out.println(CollectionUtils.isEmpty(list2)); // Output: true
        System.out.println(CollectionUtils.isEmpty(list3)); // Output: false

        // 5) Boolean.TRUE.equals
        System.out.println("\n5) Boolean.TRUE.equals");
        Boolean otherBoolean = null;
        System.out.println(Boolean.TRUE.equals(otherBoolean));

    }
}
