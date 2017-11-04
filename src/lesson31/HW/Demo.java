package lesson31.HW;

/**
 * Created by Kushn_000 on 22.10.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.countSymbols("В этом задании присутствует только " +
                "базовая проверка кода, для детальной проверки вышлите пожалуйста ссылку " +
                "на верное решение ментору в чате"));

        System.out.println();

        System.out.println(solution.countSymbols("В этом задании кода 125436 присутствует, только чате кое-что " +
                "базовая чате проверка: на кода для детальной qweer456gkjl проверки вышлите. Для пожалуйста ссылку " +
                "на верное решение как-нибудь ментору в чате! example@mail.com.ua - электронный адрес."));

        System.out.println();

        System.out.println(solution.words("В этом задании кода 125436 присутствует9, только чате кое-что " +
                "базовая чате проверка: на кода для детальной qweer456gkjl проверки вышлите. Для пожалуйста ссылку " +
                "на верное решение как-нибудь harakiri ментору в чате! example@mail.com.ua - электронный адрес."));
    }
}
