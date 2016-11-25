/**
 * @author SYESILDAG
 */
package debounce;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DebounceStore<K>
{
   private Map<K, DebounceExecutor> store;
   
   public DebounceStore()
   {
      this.store = new ConcurrentHashMap<K, DebounceExecutor>();
   }
   
   public boolean contains(K k) {
      return this.store.containsKey(k);
   }
   
   public DebounceExecutor register(K k) {
      this.store.put(k, new DebounceExecutor());
      return get(k);
   }
   
   public DebounceExecutor get(K k) {
      return this.store.get(k);
   }
   
   public DebounceExecutor registerOrGet(K k) {
      if (!contains(k))
         register(k);
      
      return get(k);
   }
}
