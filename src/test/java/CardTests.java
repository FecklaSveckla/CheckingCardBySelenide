import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class CardTests {

    @BeforeEach
    void shouldOpenBrowser() {
        open("http://localhost:7777/");
    }


    @Test
    public void shouldSendForm() {
        $("[type=text]").setValue( "Иван Иванов" );
        $("[type=tel]").setValue( "+79261234567");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=order-success]").shouldHave( exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.") );

    }


    @Test
    public void shouldSendFormWithDashInName() {
        $("[type=text]").setValue( "Иван Иванов-Петров" );
        $("[type=tel]").setValue( "+79261234567");
        $(".checkbox__box").click();
        $(".button__content").click();
        $("[data-test-id=order-success]").shouldHave( exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.") );

    }

//    @Test
//    public void shouldSendFormWithLitter() {
//        $("[type=text]").setValue( "Алёна Савина" );
//        $("[type=tel]").setValue( "+79261234567");
//        $(".checkbox__box").click();
//        $(".button__content").click();
//        $("[data-test-id=order-success]").shouldHave( exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.") );
//
//    }

}
