# refactoring

# قسمت دوم

## اعمال الگوی facade

برای اینکار یک کلاس facade برای عملکرد اصلی خود MiniJava که در Main از آن استفاده شده بود، ایجاد کردیم. آنجا مجبور بودیم از پارسر استفاده کنیم و یک اسکنر بسازیم و در نهایت ارور هندلینگ را هم انجام دهیم. هر جای دیگر هم اگر میخواستیم این استفاده را تکرار کنیم، باید همین مراحل را طی میکردیم. اما با ساخت MiniJavaFacade یک اینترفیس مشخص و مینیمال برای compile در اختیار کلاینت که در اینجا Main است قرار دادیم.

## استفاده از polymorphism

در کلاس MiniJava.parser.Action تابع زیر وجود دارد:

```java
public String toString() {
    switch (action) {
        case accept:
            return "acc";
        case shift:
            return "s" + number;
        case reduce:
            return "r" + number;
    }
    return action.toString() + number;
}
```

این تابع می‌تواند با یک polymorphism جایگزین شود. علاوه بر این فیلد number در نوع accept استفاده‌ای ندارد و همچنین در shift و reduce دو مفهوم متفاوت است. لذا در کل بهتر است این کلاس را به ۳ زیر کلاس تبدیل کنیم.

## Self Encapsulate Field

در کلاس Memory برای فیلد codeblock یک protected getter اضافه کردیم و در دیگر قسمت‌های کلاس از آن استفاده نمودیم. همچنین برای کلاس داخلی \_3AddressCode مشابه این کار را انجام دادیم. توجه شود که در این کلاس داخلی، فیلد‌ها نیز به صورت public تعریف شده‌بودند که آن‌ها نیز به حالت private تغییر داده شدند.
