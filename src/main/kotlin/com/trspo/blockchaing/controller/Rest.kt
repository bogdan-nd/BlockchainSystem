package com.trspo.blockchaing.controller

import com.trspo.blockchaing.entity.Block
import com.trspo.blockchaing.repo.BlockChainRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("abc")
class Rest {
    @Autowired
    lateinit var blockChainRepository: BlockChainRepository

    @PostMapping
    fun a(@RequestBody block:Block):String{
        blockChainRepository.save(block)
        return "Success"
    }

    @GetMapping
    fun ab(): List<Block> {
        return blockChainRepository.findAll()
    }


}