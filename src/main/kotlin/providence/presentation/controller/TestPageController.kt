package providence.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class TestPageController {
    @GetMapping("/")
    fun list(model: Model): String {
        return "index"
    }
}