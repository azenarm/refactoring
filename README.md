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