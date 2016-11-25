/**
 * @author SYESILDAG
 */
package debounce;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import interceptors.Interceptor;
import interceptors.InvocationContext;

public class DebounceMethodInterceptor implements Interceptor
{
   @SuppressWarnings("unused")
   private static DebounceStore<String> store = new DebounceStore<String>();
   
   public DebounceMethodInterceptor()
   {
   }
   
   /* (non-Javadoc)
    * @see interceptors.Interceptor#intercept(interceptors.InvocationContext)
    */
   @Override
   public Object intercept(InvocationContext ctx)
      throws Exception
   {
      Method method = ctx.getMethod();
      Debounce debounceAnnotation = method.getAnnotation(Debounce.class);
      
      if(debounceAnnotation == null)
         return ctx.proceed();
      
      DebounceExecutor debouncer = store.get(getKey(ctx).toString());
      
      return debouncer.debounce(debounceAnnotation.delayMilliseconds(), new DebounceTask(ctx));
   }
   
   static StringBuilder getKey(InvocationContext ctx)
   {
      Method method = ctx.getMethod();
      
      StringBuilder key = new StringBuilder(method.toString());
      
      Object[] args = ctx.getArgs();
      
      int idx = 0;
      
      Annotation[][] parameterAnnotations = method.getParameterAnnotations();
      for(Annotation[] annotations : parameterAnnotations)
      {
         for(Annotation annotation : annotations)
            if(annotation instanceof Key)
            {
               key.append(" " + args[idx]);
               break;
            }
         
         idx++;
      }
      return key;
   }
}
