import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1) Для данной задачи я выбрал кол-ию HashMap, тк нам нужно по ключу(Имя автора, Название Книги, Год публикации) получить
 *      значение - Книга и делать это быстро! А сложность HashMap при правильном определении hashcode гарантирует нам сложность O(1).
 * 2) Сложность методов: O(1)
 * 3) Так как ключом всех кол-ций является стандартные классы String и Integer
 *         hashCode and equals уже определены в этих классах => 1) --//--
 */
public class Library {
    Map<String, List<Book>> nameMap = new HashMap<>();
    Map<String, List<Book>> authorMap = new HashMap<>();
    Map<Integer, List<Book>> yearMap = new HashMap<>();

    public void addBook(Book book){
        if(nameMap.containsKey(book.name())){
            nameMap.get(book.name()).add(book);
        }
        else{
            List<Book> lst = new ArrayList<>();
            lst.add(book);
            nameMap.put(book.name(), lst);
        }

        if(authorMap.containsKey(book.author())){
            authorMap.get(book.author()).add(book);
        }
        else{
            List<Book> lst = new ArrayList<>();
            lst.add(book);
            authorMap.put(book.author(), lst);
        }

        if(yearMap.containsKey(book.year())){
            yearMap.get(book.year()).add(book);
        }
        else {
            List<Book> lst = new ArrayList<>();
            lst.add(book);
            yearMap.put(book.year(), lst);
        }
    }

    public List<Book> getBook(RequestCriterion requestCriterion, String request){
        switch (requestCriterion){
            case NAME -> {
                return nameMap.get(request);
            }
            case AUTHOR -> {
                return authorMap.get(request);
            }
            default -> {
                return null;
            }
        }
    }

    public List<Book> getBook(RequestCriterion requestCriterion, int request){
        switch (requestCriterion){
            case PUB_YEAR -> {
                return yearMap.get(request);
            }
            default -> {
                return null;
            }
        }
    }

    public List<Book> getBook(RequestCriterion requestCriterion, int start, int end){
        List<Book> result = new ArrayList<>();
        switch (requestCriterion){
            case YEAR_DIAPASON -> {
                for(int i = start; i <= end; i++){
                    result.addAll(yearMap.get(i));
                }
            }
            default -> {
                return null;
            }
        }
        return result;
    }
}