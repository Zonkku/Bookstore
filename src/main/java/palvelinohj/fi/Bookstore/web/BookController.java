package palvelinohj.fi.Bookstore.web;

import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import antlr.collections.List;
import palvelinohj.fi.Bookstore.domain.BookRepository;


@Controller
public class BookController {

	@Autowired
	private BookRepository repository; 
	
	public void doSomething() {
		List<Book> books = repository.findByTitle(" ");
	}
	
    @RequestMapping(value="/bookList")
    public String bookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "bookList";
    }
  
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
    	return "redirect:../bookList";
    }
    
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addBook";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book) {
    	repository.save(book);
    	return "redirect:bookList";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String addBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        return "editbook";
    }
    
    
}




