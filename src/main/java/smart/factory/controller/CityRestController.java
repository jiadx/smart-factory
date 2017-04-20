package smart.factory.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smart.factory.domain.City;
import smart.factory.service.CityService;

import java.util.List;

/**
 * Created by jiadx on 17-4-13.
 */
@RestController
@RequestMapping(value = "/api/city/")
public class CityRestController {
    @Autowired
    private CityService cityService;

    @ApiOperation(value = "获取某一个城市", notes = "根据url的id来获取获取某一个城市详细信息")
    @ApiImplicitParam(name = "id", value = "城市id", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
