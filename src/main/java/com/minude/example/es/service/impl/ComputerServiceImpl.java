package com.minude.example.es.service.impl;

import com.minude.example.es.domain.entity.Computer;
import com.minude.example.es.domain.model.ComputerDto;
import com.minude.example.es.service.ComputerService;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.search.Query;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryShardContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author minude
 * @version 1.0
 * @date 2019-08-27 17:39
 */
@Service
public class ComputerServiceImpl implements ComputerService {

    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    public void setElasticsearchTemplate(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    @Override
    public ComputerDto save(ComputerDto dto) {

        Computer computer = new Computer(dto);
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(computer).build();
        String result = elasticsearchTemplate.index(indexQuery);
        System.out.println(result);
        return computer.transferDto();
    }

    @Override
    public Boolean delete(String id) {

        String result = elasticsearchTemplate.delete(Computer.class, id);
        System.out.println(result);
        return true;
    }

    @Override
    public Boolean update(ComputerDto dto) {

        return null;
    }

    @Override
    public ComputerDto detail(String id) {

        return null;
    }

    @Override
    public List<ComputerDto> list(String keyword, Pageable pageable) {

        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder().withPageable(pageable);
        if (StringUtils.isNotBlank(keyword)) {
            QueryBuilder queryBuilder = new MatchQueryBuilder("brand", keyword);
            builder.withQuery(queryBuilder);
        }
        SearchQuery searchQuery = builder.build();
        List<Computer> computers = elasticsearchTemplate.queryForList(searchQuery, Computer.class);
        return computers.stream().map(Computer::transferDto).collect(Collectors.toList());
    }
}
