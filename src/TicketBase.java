import java.util.HashMap;
import java.util.Map;

/**
 * 1) Я выбрал коллекцию HashMap, потому что: я хочу по ключу(номеру билета) получить значение (товары) и делать это быстро!
 *   А сложность HashMap при правильном определении hashcode гарантирует нам сложность O(1)
 * 2) Сложность алгоритма O(1)
 * 3) Тк ключ типа String, hashCode and equals уже определены в этом классе => 1) --//--
 */
public class TicketBase {
    private final Map<String, ProductSet> ticketArchive = new HashMap<>();

    public String getFoodInfo(String ticketNumber){
        ProductSet currentSet = ticketArchive.get(ticketNumber);
        if(currentSet == null) return "No have ticket";
        switch (currentSet){
            case DRINKS -> {
                return "Need drink";
            }
            case EAT_AND_DRINKS -> {
                return "Need drink and food";
            }
            case NOTHING -> {
                return "Nothing";
            }
            default -> {
                return null;
            }
        }
    }

    public void addTicketInArchive(String ticketNumber, ProductSet productSet){
        if(ticketArchive.containsKey(ticketNumber)){
            System.out.println("Ticket contains in base");
            return;
        }
        ticketArchive.put(ticketNumber, productSet);
    }
}