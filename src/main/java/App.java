import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

public class App {

  public static void main (String[] args) {
    staticFileLocation ("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("CDList", request.session().attribute("CDList"));
      model.put("template", "templates/form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/CD", (request, response)->{
        Map<String, Object> model = new HashMap<String, Object>();
        ArrayList<CD> cds = request.session().attribute("CDList");
        if (cds == null){
          cds = new ArrayList<CD>();
          request.session().attribute("CDList", cds);
        }
        String stringGenre = request.queryParams("genre");
        String stringArtist = request.queryParams("artist");
        String stringTitle = request.queryParams("title");
        String stringYear = request.queryParams("year");
        Integer intYear = Integer.parseInt(stringYear);

        CD newList = new CD(stringGenre, stringArtist, stringTitle, intYear);
        model.put("template", "templates/CDList.vtl");
        model.put("cd", stringTitle);
        cds.add(newList);
        return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

  }
}
