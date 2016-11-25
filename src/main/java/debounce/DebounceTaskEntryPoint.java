/**
 * @author SYESILDAG
 */
package debounce;

import interceptors.InvocationContext;

public class DebounceTask extends java.util.concurrent.Callable<Object>
{
   private static final long serialVersionUID = 1L;
   
   private InvocationContext ctx;
   
   public DebounceTask()
   {
   }
   
   public DebounceTask(InvocationContext ctx)
   {
      this.ctx = ctx;
   }
   
   @Override
   public Object call()
   {
      return this.ctx.proceed();
   }
}
