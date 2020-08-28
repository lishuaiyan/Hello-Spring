package net.duxingzhe.luke.spring.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author luke.yan
 * @Description 使用@Controller注解，会自动注册为Spring应用程序上下文里的一个Bean
 *              使用@RequestMapping注解将其中所有的处理器方法都映射到了"/"这个URL路径上
 */
@Controller
@RequestMapping("/api")
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    /**
     * 处理/{reader}上的HTTP GET请求，根据路径里指定的读者，从(通过控制器的构造器注入的)仓库获取Book列表
     * 随后将这个列表塞入模型，用的键是books，最后返回readingList作为呈现吗，模型的视图逻辑名称
     * 该方法最后返回readingList作为逻辑视图名称，为此必须创建该视图
     * @param reader 读者
     * @param model 模型
     * @return 视图逻辑名称
     */
    @RequestMapping(value="/{reader}", method= RequestMethod.GET)
    public String readersBooks(
            @PathVariable("reader") String reader,
            Model model
    ) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    /**
     * 处理/{reader}上的HTTP POST请求，将请求正文里的数据绑定到一个Book对象上。
     * 该方法把Book对象的reader属性设置为读者的姓名，随后通过仓库的save()方法保存修改后的Book对象，最后重定向的/{reader}(控制器中的另一个方法会处理该请求)
     * @param reader 读者
     * @param book Book
     * @return 重定向
     */
    @RequestMapping(value="/{reader}", method=RequestMethod.POST)
    public String addToReadingList(
            @PathVariable("reader") String reader,
            Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
