# refactoring

# قسمت دوم

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
در کلاس Memory برای فیلد codeblock یک protected getter اضافه کردیم و در دیگر قسمت‌های کلاس از آن استفاده نمودیم. همچنین برای کلاس داخلی _3AddressCode مشابه این کار را انجام دادیم. توجه شود که در این کلاس داخلی، فیلد‌ها نیز به صورت public تعریف شده‌بودند که آن‌ها نیز به حالت private تغییر داده شدند.