package net.duxingzhe.luke.spring.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author luke.yan
 * @Description 通过扩展 JpaRepository ReadlingListRepository 直接继承了18个执行常用持久化操作的方法
 * JpaRepository 是个泛型接口，有两个参数 数据库操作的领域对象类型，及其ID属性的类型
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    /**
     * 根据读者的用户名来查找阅读列表
     * @param reader 读者用户名
     * @return 阅读列表
     */
    List<Book> findByReader(String reader);
}
