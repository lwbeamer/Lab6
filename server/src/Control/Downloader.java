package Control;



import WorkerData.Worker;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

/**
 * Класс для парсинга и загрузки в коллекцию элементов из файла
 */
public class Downloader {

    private final String path;
    private final Validator validator;
    private String parent;
    private String field;

    public Downloader(String path, Validator validator) {
        this.path = path;
        this.validator = validator;
    }

    /**
     * Метод, который находит нужные узлы в документе.
     */
    public void readCollection() {
        try {
            // Получение фабрики, чтобы после получить билдер документов.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
            Document document = builder.parse(new File(path));

            NodeList workersElements = document.getElementsByTagName("Workers");

            if (workersElements.getLength() != 0) {

                // Получение первого элемента.
                Node foundedElement = workersElements.item(0);

                // Если есть данные внутри, вызов метода для вывода всей информации
                if (foundedElement.hasChildNodes())
                    findInfoAboutAllChildNodes(foundedElement.getChildNodes());
            }
        } catch (IOException | NullPointerException e){
            ServerConsole.printError("Файл не найден. Проверьте правильность указанного пути и попробуйте ещё раз");
            System.exit(0);
        } catch (SAXException|ParserConfigurationException e){
            ServerConsole.printError("Ошибка в структуре XML - файла. Проверьте его корректность!");
            System.exit(0);
        }
    }


    /**
     *Метод ищет дочернии узлы в элементах и передаёт их валидатору.
     * @param list - список узлов
     */
    private void findInfoAboutAllChildNodes(NodeList list) {

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);

            // У элементов есть два вида узлов - другие элементы или текстовая информация. Потому нужно разбираться две ситуации отдельно.
            if (node.getNodeType() == Node.TEXT_NODE) {
                // Фильтрация информации, так как пробелы и переносы строчек нам не нужны. Это не информация.
                String textInformation = node.getNodeValue().replace("\n", "").trim();
                if(!textInformation.isEmpty()) {
                    validator.check(field, parent,node.getNodeValue());
                    // ServerConsole.printError(node.getParentNode());
                }
            }
            // Если это не текст, а элемент, то обрабатываем его как элемент.
            else {
                parent = node.getParentNode().getNodeName();
                field = node.getNodeName();
                if (field.equals("Worker")){
                    validator.addElement();
                }
            }

            // Если у данного элемента еще остались узлы, то вывести всю информацию про все его узлы.
            if (node.hasChildNodes())
                findInfoAboutAllChildNodes(node.getChildNodes());
        }
    }

    public ArrayDeque<Worker> getCollection(){
        return validator.getWorkers();
    }
}
