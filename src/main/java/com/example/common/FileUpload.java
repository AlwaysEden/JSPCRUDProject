package com.example.common;
//<%@ page contentType="text/html;charset=UTF-8" language="java" %>
//<%@ page language="java" contentType="text/html; charset=UTF-8"
//        pageEncoding="UTF-8"%>
//<%@ page import ="java.io.File" %>
//<%@ page import ="com.oreilly.servlet.*" %>
//<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

import java.io.File;
import java.io.IOException;

import com.example.bean.BoardVO;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.http.HttpServletRequest;
import com.example.dao.BoardDAO;
public class FileUpload {
    public BoardVO uploadPhoto(HttpServletRequest request) {
        String filename = "";
        int sizeLimit = 15 * 1024 * 1024;

        String realPath = request.getServletContext().getRealPath("upload");
        File dir = new File(realPath);
        if(!dir.exists()) dir.mkdirs();

        BoardVO one = null;
        MultipartRequest multipartRequest = null;

        try{
            multipartRequest = new MultipartRequest(request, realPath,
                    sizeLimit, "utf-8",new DefaultFileRenamePolicy());
            filename = multipartRequest.getFilesystemName("attachment");
            one = new BoardVO();
            String seq = multipartRequest.getParameter("seq");
            if(seq!=null&&seq.equals(""))one.setSeq(Integer.parseInt(multipartRequest.getParameter("seq")));
            one.setTitle(multipartRequest.getParameter("title"));
            one.setWriter(multipartRequest.getParameter("writer"));
            one.setContent(multipartRequest.getParameter("content"));
            one.setCategory(multipartRequest.getParameter("category"));
//            one.setAttachment(multipartRequest.getParameter("attachment"));
//            one.setCnt(Integer.parseInt(multipartRequest.getParameter("cnt")));

            if(seq!=null && !seq.equals("")){
                BoardDAO dao = new BoardDAO();
                String oldfilename = dao.getPhotoFilename(Integer.parseInt(seq));
                if(filename!=null && oldfilename != null)
                    FileUpload.deleteFile(request, oldfilename);
                else if(filename==null && oldfilename != null)
                    filename = oldfilename;
            }
            one.setAttachment(filename);
        }catch(IOException e){
            e.printStackTrace();
        }
        return one;
    }
    public static void deleteFile(HttpServletRequest request, String filename){
        String filePath = request.getServletContext().getRealPath("upload");

        File f = new File(filePath + "/" + filename);
        if(f.exists()) f.delete();
    }
}
