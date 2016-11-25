/**
 * @author SYESILDAG
 */
package debounce;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class DebounceStore<K>
{
   private Map<K, DebounceExecutor> store;
   
   @SuppressWarnings("unused")
   public DebounceStore()
   {
      this.store = new ConcurrentHashMap<K, DebounceExecutor>();
   }
   
   public DebounceExecutor get(K k) {
      
      return this.store.computeIfAbsent(k, new Function<K, DebounceExecutor>()
      {
         /* (non-Javadoc)
          * @see java.util.function.Function#apply(java.lang.Object)
          */
         @Override
         public DebounceExecutor apply(K t)
         {
            return new DebounceExecutor();
         }
      });
   }
}
