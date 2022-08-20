package cache;

import annotations.Cachable;
import serialization.SrializeList;
import service.Service;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
Логика по кэшированию должна быть сделана с помощью DynamicProxy. Должен быть
класс CacheProxy с методом cache(), который принимает ссылку на сервис и возвращает
кэшированную версию этого сервиса. CacheProxy можеттоже принимать в конструкторе
некоторые настройки, например, папку, в которой хранить файлы, дефолтные настройки
кэша и т.д.
 */
public class CacheProxy {
    private String pathToFile;
    private String fileName;
    private boolean zip;

    public CacheProxy(){
        this.pathToFile = "src/main/resources";
        this.fileName = "cacheService";
        this.zip = true;
    }

    public Service cache(Service service){
        try{
            return (Service) Proxy.newProxyInstance(
                    ClassLoader.getSystemClassLoader(),
                    new Class[]{Service.class},
                    new LogHandler(this, service));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Cachable(filePrefix = "cache", zip = true)
    public void writeToFile(Object o, String file) throws IOException {
        SrializeList.serialize(file, o);
        if (zip) {
            File fileZip = new File(file.replaceFirst(".bin", "") + ".zip");
            try (ZipOutputStream zipOut = new ZipOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(fileZip))))
            {
                zipOut.putNextEntry(new ZipEntry(file.replaceFirst(Pattern.quote(pathToFile), "")));
                Files.copy(Paths.get(file), zipOut);
                zipOut.closeEntry();
            }
        }
    }

    public boolean isNeedCashed() {
        try {
            return this.getClass().getMethod("writeToFile", Object.class, String.class).isAnnotationPresent(Cachable.class);
        } catch (NoSuchMethodException e) {
            System.err.println("Error. " + e.getMessage());
            return false;
        }
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isZip() {
        return zip;
    }

    public void setZip(boolean zip) {
        this.zip = zip;
    }
}
