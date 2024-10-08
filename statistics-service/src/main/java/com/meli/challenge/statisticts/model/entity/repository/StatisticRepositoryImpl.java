package com.meli.challenge.statisticts.model.entity.repository;

import com.meli.challenge.statisticts.model.entity.Statistic;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@AllArgsConstructor
public class StatisticRepositoryImpl implements StatisticRepository {
    private RedisTemplate<String, Statistic> redisTemplate;

    @Override
    public Optional<Statistic> findByShortUrl(String shortUrl) {
        Statistic statistic = redisTemplate.opsForValue().get(shortUrl);
        return Optional.ofNullable(statistic);
    }

    @Override
    public void save(Statistic statistic) {
        log.info("Saving statistic at: {}", LocalDateTime.now());
        redisTemplate.opsForValue().set(statistic.getShortUrl(), statistic, 24, TimeUnit.HOURS);
    }
}
