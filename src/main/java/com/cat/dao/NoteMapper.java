package com.cat.dao;

import com.cat.pojo.Note;
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

    List<Note> selectNoteByManId(@Param("manId") Integer manId);

}