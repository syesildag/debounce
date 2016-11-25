/**
 * @author SYESILDAG
 */
package debounce;

import interceptors.InvocationContext;

public class DebounceTask implements java.util.concurrent.Callable<Object>
{
   private InvocationContext ctx;
   
   public DebounceTask()
   {
   }
   
   public DebounceTask(InvocationContext ctx)
   {
      this.ctx = ctx;
   }
   
   /* (non-Javadoc)
    * @see java.util.concurrent.Callable#call()
    */
   @Override
   public Object call() throws Exception
   {
      return this.ctx.proceed();
   }
}
