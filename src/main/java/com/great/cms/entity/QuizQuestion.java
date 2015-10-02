/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.great.cms.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Biswajit Debnath
 */
@Entity
@Table(name = "quiz_question")
@NamedQueries({
    @NamedQuery(name = "QuizQuestion.findAll", query = "SELECT q FROM QuizQuestion q"),
    @NamedQuery(name = "QuizQuestion.findByQuizQuestionId", query = "SELECT q FROM QuizQuestion q WHERE q.quizQuestionId = :quizQuestionId")})
public class QuizQuestion implements DomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "quiz_question_id")
    private Long quizQuestionId;
    @JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id")
    @ManyToOne(optional = false)
    private Quiz quizId;
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    @ManyToOne(optional = false)
    private Question questionId;

    public QuizQuestion() {
    }

    public QuizQuestion(Long quizQuestionId) {
        this.quizQuestionId = quizQuestionId;
    }

    public Long getQuizQuestionId() {
        return quizQuestionId;
    }

    public void setQuizQuestionId(Long quizQuestionId) {
        this.quizQuestionId = quizQuestionId;
    }

    public Quiz getQuizId() {
        return quizId;
    }

    public void setQuizId(Quiz quizId) {
        this.quizId = quizId;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quizQuestionId != null ? quizQuestionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuizQuestion)) {
            return false;
        }
        QuizQuestion other = (QuizQuestion) object;
        if ((this.quizQuestionId == null && other.quizQuestionId != null) || (this.quizQuestionId != null && !this.quizQuestionId.equals(other.quizQuestionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.entity.QuizQuestion[ quizQuestionId=" + quizQuestionId + " ]";
    }
    
}