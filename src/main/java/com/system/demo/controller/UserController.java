package com.system.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.system.demo.annotation.Login;
import com.system.demo.common.entity.JsonResult;
import com.system.demo.model.User;
import com.system.demo.repository.Login.LoginThirdRepository;
import com.system.demo.service.IUserService;
import io.swagger.annotations.*;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
@Api(tags = "用户模块")
@Login
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService iUserService;



//    /**
//     * 用户登陆
//     *
//     * @param user 用户信息
//     * @return 200成功 202异常 400失败
//     */
//    @PostMapping("/login")
//    @ApiOperation(value = "用户登陆", produces = "application/json")
//    public ResponseEntity<String> login(@RequestBody User user){
//
//        Map<String,Object> result = new HashMap<String, Object>();
//        System.err.println(user);
//        if("admin".equals(user.getName()) && "123456".equals(user.getPassWord())) {
//            result.put("code", 200);
//            result.put("msg", "登录成功");
//            result.put("token", "adminxxxx");
//            return new ResponseEntity(result, HttpStatus.OK);
//        }
//
//
//        result.put("code", 500);
//        result.put("msg", "登录失败");
//
//        return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }

    @Autowired
    LoginThirdRepository loinServer;
    /**
     * 用户登陆
     *
     * @param user 用户信息
     * @return 200成功 202异常 400失败
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登陆", produces = "application/json")
    public ResponseEntity<String> login(@RequestBody User user)  throws IOException {

        Map<String,Object> result = new HashMap<String, Object>();
        System.err.println(user);

        //获取token
        Response response = loinServer.getToken(user.getName(),user.getPassWord());

        System.out.println("token---"+response.code());

        //成功了继续访问登录
        if(response.isSuccessful()) {

            JSONObject jsonObject = JSONObject.parseObject(response.body().string());


            if (("").equals(jsonObject.get("data"))){
                result.put("code", 500);
                result.put("msg", "登录异常");

                return new ResponseEntity(result, HttpStatus.OK);
            }


            Response responseLogin = loinServer.login(user.getName(),jsonObject.getString("data"));

            if(responseLogin.isSuccessful()){
                result.put("code", 200);
                result.put("msg", "登录成功");
                result.put("token", "adminxxxx");
                return new ResponseEntity(result, HttpStatus.OK);
            }

           // JSONObject jsonObjectLogin = JSONObject.parseObject(responseLogin.body().string());

            result.put("code", responseLogin.code());

            if(responseLogin.code()==401){
                result.put("msg", "登录的已超时，请重新登录");
            }
            else {
                result.put("msg", "登录失败");
            }

            return new ResponseEntity(result, HttpStatus.OK);

        }


        result.put("code", 500);
        result.put("msg", "登录失败");

        return new ResponseEntity(result, HttpStatus.OK);

    }


//    /**
//     * 用户查询姓名
//     *
//     * @param
//     * @return 200成功 202异常 400失败
//     */
//    @GetMapping
//    @ApiOperation(value = "用户查询根据姓名", produces = "application/json")
//    public ResponseEntity<String> listUserName(String name){
//        System.out.println(name);
//        return new ResponseEntity(iUserService.listUserName(name), HttpStatus.OK);
//
//    }
//
//
//    /**
//     * 用户查询
//     *
//     * @param
//     * @return 200成功 202异常 400失败
//     */
//    @GetMapping("/list")
//    @ApiOperation(value = "用户查询", produces = "application/json")
//    public ResponseEntity<String> listUser(){
//
//        return new ResponseEntity(iUserService.listUser(), HttpStatus.OK);
//
//    }
//
//    @ResponseBody
//    @PostMapping
//    @ApiOperation(value="新增")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType="query", name = "password", value = "旧密码", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType="query", name = "username", value = "用户账号", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType="query", name = "name", value = "用户昵称", required = true, dataType = "String")
//    })
//    public JsonResult addUser(String username, String password, String name){
//        User u = new User();
//        u.setName(username);
//        u.setPassWord(password);
//        u.setNickName(name);
//        int result = iUserService.addUser(u);
//        System.out.println(result);
//        System.out.println(result==1?true:false);
//        return new JsonResult(result==1?true:false);
//    }
//
//
//    /**
//     * 用户修改
//     *
//     * @param
//     * @return 200成功 202异常 400失败
//     */
//    @ResponseBody
//    @PutMapping
//    @ApiOperation(value = "用户修改", produces = "application/json")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType="query", name = "password", value = "旧密码", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType="query", name = "username", value = "用户账号", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType="query", name = "name", value = "用户昵称", required = true, dataType = "String")
//    })
//    public JsonResult updateUser(String name, String password, String username){
//
//        User u = new User();
//        u.setName(name);
//        u.setPassWord(password);
//        u.setNickName(username);
//        System.out.println(u.toString());
//        int result = iUserService.updateUser(u);
//        System.out.println(result);
//        System.out.println(result==1?true:false);
//        return new JsonResult(result==1?true:false);
//    }
//
//
//    /**
//     * 用户修改
//     *
//     * @param
//     * @return 200成功 202异常 400失败
//     */
//    @DeleteMapping("/{id}")
//    @ApiOperation(value = "用户删除", produces = "application/json")
//    public JsonResult delUser(@PathVariable Long id){
//
//        int result = iUserService.delUser(id);
//        System.out.println(result);
//        System.out.println(result==1?true:false);
//        return new JsonResult(result==1?true:false);
//    }

}
