    package com.xiaoyongcai.io.designmode.Controller.StructuralPatterns.FlyweightPattern;

    import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.FlyweightPattern.TagService;
    import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.FlyweightPattern.Tag;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/FlyweightPattern")
    public class FlyweightPatternController {
        @Autowired
        private TagService tagService;

        @GetMapping("/tags")
            public Tag getProductTag(@RequestParam String name, @RequestParam String color, @RequestParam String description) {
            return tagService.getTagForProduct(name, color, description);
        }
    }
