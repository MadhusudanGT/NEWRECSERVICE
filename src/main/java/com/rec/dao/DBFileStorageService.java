package com.rec.dao;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import com.rec.model.DbFile;
import com.rec.repository.DbfileRepo;
 

@Service
public class DBFileStorageService {

    @Autowired
    private DbfileRepo dbFileRepository;

    public DbFile storeFile(MultipartFile file) throws Exception {
    	
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DbFile dbFile = new DbFile(null, fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!" + ex);
        }
    }

    public DbFile getFile(Long fileId) throws Exception{
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new Exception("File not found with id " + fileId));
    }
}