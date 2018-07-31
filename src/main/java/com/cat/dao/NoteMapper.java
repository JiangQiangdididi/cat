package com.cat.dao;

import com.cat.entity.Note;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKeyWithBLOBs(Note record);

    int updateByPrimaryKey(Note record);

    Note selectByIdAndUserName(@Param("userId") Integer userId, @Param("username") String username);

    List<Note> selectNoteByManId(@Param("manId") Integer manId);

}