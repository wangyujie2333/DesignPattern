package com.design.behavior.intermediary.design.dao;

import com.design.behavior.intermediary.design.po.School;

public interface ISchoolDao {

    School querySchoolInfoById(Long treeId);

}
