package dv.temporary;

import com.sun.deploy.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by DV on 04.07.17.
 */
public class Main {
    public static void main(String[] args) {
        prntLn(KoansTasksKt.start());

        String[] arrStr = {"1", "2", "3"};
        List<String> arrayList = Arrays.asList(arrStr);
        prntLn("Named arguments:");
        prntLn(KoansTasksKt.joinOptions(arrayList));

        prntLn("Default arguments:");
        prntLn(KoansTasksKt.useFoo().toString());

        Integer[] arr = {1, 2, 3, 4};
        List<Integer> list = Arrays.asList(arr);
        prntLn("Contains even (1, 2, 3, 4):");
        prntLn(KoansTasksKt.containsEven(Arrays.asList(arr)));

        prntLn("Strings:");
        prntLn(KoansTasksKt.getPattern());

        prntLn("Data classes:");
        prntLn(KoansTasksKt.getPeople().toString());

        prntLn("Nullable types:");
        KoansTasksKt.sendMessageToClient(new Client(new PersonalInfo("emailParam")), "messageParam", new Mailer() {
            @Override
            public void sendMessage(@NotNull String email, @NotNull String message) {
                prntLn("email:" + email + " message:" + message);
            }
        });

        prntLn("Smart casts:");
        prntLn(KoansTasksKt.eval(new Num(1)));
        prntLn(KoansTasksKt.eval(new Sum(new Num(2), new Num(5))));


    }

    private static <T> void prnt(T s) {
        System.out.print(s);
    }

    private static <T> void prntLn(T s) {
        System.out.println(s);
    }
}
