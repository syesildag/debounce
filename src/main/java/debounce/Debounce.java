/**
 * @author SYESILDAG
 */
package debounce;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Debounce
{
   long delayMilliseconds() default 0;
}
